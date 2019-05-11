#!/bin/zsh

ROOT=$(pwd)
tmpDir="trace"
LIST=('ArrayList' 'LinkedList')
SORT=('Insert' 'Bubble' 'Quick')
pathToJarAgent="/home/nharrand/Documents/yajta/target/yajta-2.0.0-jar-with-dependencies.jar"
INPUTS_SMALL="1 5 10 6 8"
INPUTS_MEDIUM="1 5 10 6 8 85 4 1 2 15 -5 -10 15 20 30 40"
INPUTS_BIG="1 5 10 6 8 85 4 1 2 15 -5 -10 15 20 30 40 1 5 10 6 8 85 4 1 2 15 -5 -10 15 20 30 40 1 5 10 6 8 85 4 1 2 15 -5 -10 15 20 30 40 1 5 10 6 8 85 4 1 2 15 -5 -10 15 20 30 40"

mkdir $tmpDir

for l in $LIST
do
	for s in $SORT
	do
		echo "Sort a $l with $s"
		cmd="java -javaagent:$pathToJarAgent=\"strict-jar|jars=$ROOT/target/classes|exculdes=fr.inria.yalta|print=fasttree|output=$tmpDir/$l-$s-small.json\" -cp target/classes se.kth.sort.App $l $s $INPUTS_SMALL"
		eval ${cmd}
		cmd="java -javaagent:$pathToJarAgent=\"strict-jar|jars=$ROOT/target/classes|exculdes=fr.inria.yalta|print=fasttree|output=$tmpDir/$l-$s-medium.json\" -cp target/classes se.kth.sort.App $l $s $INPUTS_MEDIUM"
		eval ${cmd}
		cmd="java -javaagent:$pathToJarAgent=\"strict-jar|jars=$ROOT/target/classes|exculdes=fr.inria.yalta|print=fasttree|output=$tmpDir/$l-$s-large.json\" -cp target/classes se.kth.sort.App $l $s $INPUTS_BIG"
		eval ${cmd}
		#java -javaagent:$pathToJarAgent=\"strict-jar|jars=$ROOT/target/classes|exculdes=fr.inria.yalta|print=fasttree|output=$tmpDir/$l-$s.trace\" -cp target/classes se.kth.sort.App $l $s 1 5 10 6 8 85 4 1 2 15 -5 -10 15 20 30 40
	done
done
