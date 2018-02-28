#!/bin/bash

set -ux

if [ $# -eq 1 ]
then
  date=$1
else
  echo "Usgae: $0 date"
  exit 1
fi
file_name=`date -d "$date" "+%Y%m%d%H%M%S"`
x=`date -d "$date 5 second ago" "+%M%S"`
y=`date -d "$date 15 second ago" "+%M%S"`
timestamp=`expr \`date +%s%N\` / 1000000`
work_dir="/var/lib/hadoop-hdfs/li/data"
for ((i=1;i<2;i++));
do
  x=$(($x+$i))
  y=$(($y+$i))
  echo "14:34:22:be:3f:a3	$x	$y	$timestamp" >> $work_dir/$file_name
  echo "34:bb:2a:be:3f:a3       $y	$x	$timestamp" >> $work_dir/$file_name
  echo "14:aa:a9:be:3f:a3       $y	$y	$timestamp" >> $work_dir/$file_name
  echo "14:34:be:be:3f:a3       $x	$x	$timestamp" >> $work_dir/$file_name
  echo "ae:a9:09:a0:b0:ac       $x	$y	$timestamp" >> $work_dir/$file_name
done

`hdfs dfs -put $work_dir/$file_name ./stream_input`

exit 0
