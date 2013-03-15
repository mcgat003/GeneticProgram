package geneticProgramming

import java.util.Random;

class Forest {
	Random randOp= new Random()
	def best
	def treeArray=[]
	def forestSize
	def treeSize
	def sNode
	
	def Forest(numberOfTrees, tSize){
		forestSize = numberOfTrees
		treeSize = tSize
		def temp
		for (i in 0..<forestSize){
			temp = new NodeTree(treeSize)
			temp.CalcFitness()
			treeArray.push(temp)
		}
		treeArray.sort()
		best = treeArray[0]
	}
	//assumes the number of trees in the forest is divisible by 4
	def nextGeneration(){
		treeArray.sort()
		int fitForest =forestSize/2-1
		for (i in 0..(fitForest)){
			crossover(treeArray[randOp.nextInt(fitForest)],treeArray[randOp.nextInt(fitForest)],treeArray,fitForest+i+1,fitForest+i+2)
			i++
		}
		for (i in treeArray){
			i.CalcFitness()
		}
		treeArray.sort()
		if(treeArray[0].fitness < best.fitness){
			best = treeArray[0]
		}
	}
	
	def crossover(treeOne,treeTwo, arr, indexOne, indexTwo){
		NodeTree cloneOne = new NodeTree()
		NodeTree cloneTwo = new NodeTree()
		cloneOne.root = treeOne.cloneTree()
		cloneTwo.root = treeTwo.cloneTree()
		swapNodes(cloneOne,cloneTwo)
		arr[indexOne]= cloneOne
		arr[indexTwo]= cloneTwo
		
		
	}
	
	def swapNodes(treeOne,treeTwo){
		def nodeOne = findIndex(treeOne)
		def nodeTwo = findIndex(treeTwo)
		def tempTreeOne = new NodeTree()
		def tempTreeTwo = new NodeTree()
		tempTreeOne.root = treeOne.cloneTree()
		tempTreeTwo.root = treeOne.cloneTree()
		def tempOne = findIndex(tempTreeOne, nodeOne.index)
		def tempTwo = findIndex(tempTreeTwo, nodeTwo.index)
		if (nodeOne.index== 0){
			treeOne.root = tempTwo
		}else{
			for (i in 0..<nodeOne.parent.children.size()){
				if (nodeOne.index == nodeOne.parent.children[i].index){
					nodeOne.parent.children[i]= tempTwo
				}
			}
		}
		if(nodeTwo.index == 0){
			treeTwo.root = tempOne
		}else{
			for (i in 0..<nodeTwo.parent.children.size()){
				if (nodeTwo.index == nodeTwo.parent.children[i].index){
					nodeTwo.parent.children[i]= tempOne
				}
			}
		}
	}
	
	def findIndex(tree){
		def choosenIndex = randOp.nextInt(tree.calcIndex()+1)
		if (tree.root.index == choosenIndex){
			return tree.root
		}else{
			for (i in tree.root.children){
				 def temp= findIndexRecursion(i,choosenIndex)
				 if (temp !=null){
					 sNode = temp
				 }
			}
			return sNode
		}
	}
	def findIndex(tree,choosenIndex){
		tree.calcIndex()
		if (tree.root.index == choosenIndex){
		 tree.root
		}else{
			for (i in tree.root.children){
				 def temp= findIndexRecursion(i,choosenIndex)
				 if (temp !=null){
					 sNode = temp
				 }
			}
			return sNode
		}
	}
	
	def findIndexRecursion(node,choosenIndex){
		if (node.index == choosenIndex){
			if (node.index == choosenIndex){
				sNode = node
			}
		}else{
			for (i in node.children){
				findIndexRecursion(i,choosenIndex)
			}
		}
	}
	
}
