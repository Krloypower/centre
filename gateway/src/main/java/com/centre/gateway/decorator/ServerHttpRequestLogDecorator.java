package com.centre.gateway.decorator;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.core.io.buffer.DataBufferFactory;
import org.springframework.core.io.buffer.DataBufferUtils;
import org.springframework.core.io.buffer.DefaultDataBufferFactory;
import org.springframework.http.HttpMethod;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpRequestDecorator;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.nio.charset.StandardCharsets;

/**
 * @ClassName ServerHttpRequestLog
 * @Description 打印请求日志
 * @Author ouyangkang
 * @Date 2020/9/16
 * @Version 1.0
 **/
@Slf4j
public class ServerHttpRequestLogDecorator extends ServerHttpRequestDecorator {

    private final ServerWebExchange exchange;

    private static final String START_TIME = "startTime";

    public ServerHttpRequestLogDecorator(ServerWebExchange exchange) {
        super(exchange.getRequest());
        this.exchange = exchange;
        exchange.getAttributes().put(START_TIME, System.currentTimeMillis());
    }

    @Override
    public Flux<DataBuffer> getBody() {

        ServerHttpRequest request = exchange.getRequest();
        HttpMethod method = request.getMethod();


        RequestLogDTO.RequestLogDTOBuilder builder = RequestLogDTO.builder();

        if (method != null) {
            builder.methodName(method.name());
        }

        if (HttpMethod.POST == method) {
            // 异步转换 全部获取 buffer() request
            return request.getBody().buffer().flatMap(dataBuffers -> {
                DataBufferFactory factory = new DefaultDataBufferFactory();
                // 通过DataBufferFactory全部获取 dataBuffer 防止数据被截段，读取数据乱码
                DataBuffer join = factory.join(dataBuffers);
                byte[] content = new byte[join.readableByteCount()];
                join.read(content);
                DataBufferUtils.release(join);
                String postBody = new String(content, StandardCharsets.UTF_8);
                builder.body(postBody);
                log.info("RequestLogDTO={}", builder.build());
                DataBuffer buffer = exchange.getResponse().bufferFactory().wrap(postBody.getBytes(StandardCharsets.UTF_8));
                return Mono.just(buffer);
            });
        } else {
            log.info("RequestLogDTO={}", builder.build());
            return request.getBody();
        }
    }


    @Data
    @lombok.Builder
    static class RequestLogDTO {

        /**
         * 服务ip
         **/
        private String ip;

        /**
         * 请求url
         **/
        private String url;

        /**
         * 服务名
         **/
        private String serviceName;


        /**
         * 请求方法名
         **/
        private String methodName;

        /**
         * 用户id
         **/
        private String userId;

        /**
         * 用户token
         **/
        private String userToken;

        /**
         * post请求 的 body
         **/
        private String body;

    }
}
