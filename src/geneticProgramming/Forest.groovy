package geneticProgramming

import java.util.Random;

class Forest {
	Random randOp= new Random()
	def treeArray
	def GrowForest(numberOfTrees, treeSize){
		for (i in 0..<numberOfTrees){
			treeArray[i]= NodeTree(treeSize)()
		} 
	}
	def spawnOffspring(){
		
	}
	
	def crossover(treeOne,treeTwo){
		NodeTree cloneOne = new NodeTree()
		NodeTree cloneTwo = new NodeTree()
		cloneOne.root = treeOne.cloneTree()
		cloneTwo.root = treeTwo.cloneTree()
		
		
	}
	
	def chooseNode(tree){
		def choosenNode = randOp.nextInt(tree.calcIndex())
		def node = findIndex(tree)
		node
		
	}
	
	def findIndex(tree,choosenIndex){
		if (tree.root.index == choosenIndex){
			return tree.root
		}else{
			for (i in tree.root.children){
				findIndexRecursion(i,choosenIndex)
			}
		}
	}
	
	def findIndexRecursion(node,choosenIndex){
		if (node.index == choosenIndex){
			return node
		}else{
			for (i in tree.root.children){
				findIndexRecursion(i,choosenIndex)
			}
		}
	}
}
