#!/bin/sh

case $# in
0) echo "Usage: " `basename $0` " <datafile name (from the data/files_gbk folder)> "; exit 1;;
esac


datafile=$1
for i in 1 2 3 4 5 6 7 8 9 10 20 31
do
	echo
	echo "Running queryfile " query$i "on $datafile.btree.data.$i.0"
	echo
	time java -jar build/libs/GeneBankSearchBTree.jar --cache=0 --degree=0 --btreefile=$datafile.btree.data.$i.0 --length=$i --queryfile=data/queries/query$i --debug=0  > data/queries/query$i-$datafile.out
done
echo

for i in 1 2 3 4 5 6 7 8 9 10 20 31
do
	diff -w data/queries/query$i-$datafile.out results/query-results/query$i-$datafile.out
	if test "$?" = "0"
	then
		echo "----> Query-Test-$i PASSED!"
	else
		echo "----> Query-Test-$i FAILED@$#!"
	fi

done
echo

