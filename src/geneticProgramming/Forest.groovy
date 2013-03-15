package geneticProgramming

class Forest {
	def treeArray
	def GrowForest(numberOfTrees, treeSize){
		for (i in 0..<numberOfTrees){
			treeArray[i]= NodeTree(treeSize)()
		} 
	}
	def spawnOffspring(){
		
	}
}
