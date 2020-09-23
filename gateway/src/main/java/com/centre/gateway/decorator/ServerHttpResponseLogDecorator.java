package com.centre.gateway.decorator;

import lombok.extern.slf4j.Slf4j;
import org.reactivestreams.Publisher;
import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.core.io.buffer.DataBufferFactory;
import org.springframework.core.io.buffer.DataBufferUtils;
import org.springframework.core.io.buffer.DefaultDataBufferFactory;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.http.server.reactive.ServerHttpResponseDecorator;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.nio.charset.StandardCharsets;

/**
 * @ClassName ServerHttpResponseLog
 * @Description 打印请求输出日志
 * @Author ouyangkang
 * @Date 2020/9/16
 * @Version 1.0
 **/
@Slf4j
public class ServerHttpResponseLogDecorator extends ServerHttpResponseDecorator {

    private static final String START_TIME = "startTime";

    private final ServerWebExchange exchange;

    public ServerHttpResponseLogDecorator(ServerWebExchange exchange) {
        super(exchange.getResponse());
        this.exchange = exchange;
    }

    @Override
    public Mono<Void> writeWith(Publisher<? extends DataBuffer> body) {

        ServerHttpResponse serverHttpResponse = exchange.getResponse();
        DataBufferFactory factory = serverHttpResponse.bufferFactory();
        Flux<? extends DataBuffer> fluxBody = Flux.from(body);
        // fluxBody.buffer() 全部获取response
        return super.writeWith(fluxBody.buffer().map(dataBuffers -> {
            DataBufferFactory dataBufferFactory = new DefaultDataBufferFactory();
            // 通过DataBufferFactory全部获取 dataBuffer 防止数据被截段，读取数据乱码
            DataBuffer join = dataBufferFactory.join(dataBuffers);
            byte[] content = new byte[join.readableByteCount()];
            join.read(content);
            DataBufferUtils.release(join);

            String result = new String(content, StandardCharsets.UTF_8);

            Long startTime = exchange.getAttribute(START_TIME);
            if (startTime != null) {
                Long executeTime = (System.currentTimeMillis() - startTime);
                log.info(exchange.getRequest().getURI().getRawPath() + " time={}ms ", executeTime);
            }
            log.info("ResponseLog={}", result);
            byte[] uppedContent = result.getBytes(StandardCharsets.UTF_8);
            return factory.wrap(uppedContent);
        }));
    }
}
