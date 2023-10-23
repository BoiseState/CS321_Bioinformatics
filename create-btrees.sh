#!/bin/sh

case $# in
0) echo "Usage: " `basename $0` " <datafile name (from the data/files_gbk folder)> "; exit 1;;
esac

datafile=$1
for i in 1 2 3 4 5 6 7 8 9 10 20 31
do
	time java -jar build/libs/GeneBankCreateBTree.jar --cache=1 --degree=0 --gbkfile=data/files_gbk/$datafile --length=$i --cachesize=5000 --debug=1
	mv dump $datafile.dump.$i
done

