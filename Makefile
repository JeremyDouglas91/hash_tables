# Dam Data / Binary Tree  program makefile
# Jeremy du Plessis
# 26 February 2018

JC = /usr/bin/javac
JFLAGS = -g -d

.SUFFIXES = .java .class
SRCDIR=src
BINDIR=bin

$(BINDIR)/%.class: $(SRCDIR)/%.java
	$(JC) $(JFLAGS) $(BINDIR) -cp $(BINDIR):lib/jcommon-1.0.23.jar:lib/jfreechart-1.0.19.jar $<

CLASSES = \
	voter.class BinaryTreeNode.class \
	BinaryTree.class AVLTree.class \
	hashtable.class HashUtil.class \
	hashTableGui.class hashTableAVLTest.class \
	hashTableLinearTest.class hashTest.class \
	graph.class 
		
CLASS_FILES = $(CLASSES:%.class=$(BINDIR)/%.class)

default: $(CLASS_FILES)

run_gui:
	java -cp $(BINDIR) hashTableGui

run_tests:
	java -cp $(BINDIR) hashTest "run test 1"
	java -cp $(BINDIR) hashTest "run test 2"

graph:
	java -cp bin:lib/jcommon-1.0.23.jar:lib/jfreechart-1.0.19.jar graph

javadoc:
	javadoc -sourcepath src/*.java -d doc/


clean:
	rm $(BINDIR)/*.class
