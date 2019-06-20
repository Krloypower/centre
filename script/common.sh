#!/usr/bin/expect
# 匹配超时不超过2秒
set timeout 2
# 跳板机密码
set password 密码1

# 线上机器地址
set server [lindex $argv 0]
# 需要查询的内容
set context [lindex $argv 1]
# 项目的名字
set projectname [lindex $argv 2]
# 线上机器统一密码
set serverpassword 密码2
# 启动新线程
spawn ssh dev@114.80.170.68

# 期待匹配到的
expect {
    "(yes/no)?" {
        send "yes\n";
        expect "password:";
        send "${password}\n";
        exp_continue;
    }
    "password" {
        send "${password}\n";
    }
}
expect {
    "dev" {
        send "ssh ${server}\n"
        exp_continue;
    }
    "password" {
        send "${serverpassword}\n"
        exp_continue;
    }
}
expect {
    "kang.ouyang" {
        send "grep '$context' /var/log/$projectname/$projectname"
        send "_info.log"
    }
}
interact
