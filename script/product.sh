#!/bin/sh
openapi1="用户名@机器ip"
openapi2="用户名@机器ip"

fm1="用户名@机器ip"
fm2="用户名@机器ip"

business1="用户名@机器ip"
business2="用户名@机器ip"

if [ "$1" = "api1" ]
then
	expect ~/bin/common.sh $openapi1 $2 "项目名1";
elif [ "$1" = "api2" ]
then
	expect ~/bin/common.sh $openapi2 $2 "项目名2";
elif [ "$1" = "fm1" ]
then
	expect ~/bin/common.sh $fm1 $2 "项目名3";
elif [ "$1" = "fm2" ]
then
	expect ~/bin/common.sh $fm2 $2 "项目名4";
elif [ "$1" = "b1" ]
then
	expect ~/bin/common.sh $business1 $2 "项目名5"
elif [ "$1" = "b2" ]
then
	expect ~/bin/common.sh $business2 $2 "项目名6"
fi
