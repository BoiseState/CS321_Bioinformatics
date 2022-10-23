# How the queries were generated

For length  i = 1, 2, 3, 4, 5, and 6, the query files contain all possible subsequences of length i.

For length i = 7, 8, 9, 10, 20, 31, the queries were generated as follows:

```bash
for i in 7 8 9 10 20 31
do
	java QueryGenerator  $i 16384 1234 | sort | uniq > query$i 
done
```

The reason is that if we generate queries randonly, there will be duplicates. The `sort` and `uniq`
commands piped together eliminate the duplicates.
