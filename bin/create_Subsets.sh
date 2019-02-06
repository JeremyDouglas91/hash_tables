#!/bin/bash
for i in {2..1002}; 
do 
	echo $i ;
	head -n$i ../data/voter_data.csv > ../data/subsets/voter_test_$i.csv
done