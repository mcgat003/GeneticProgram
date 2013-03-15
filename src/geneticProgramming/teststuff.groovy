package geneticProgramming

class teststuff {
	def static main(args){
		Forest testForest= new Forest(8,3)
		/*for (i in testForest.treeArray){
			i.String()
			println "***"
		}
		println"next Gen" */
		testForest.nextGeneration()
		/*for (i in testForest.treeArray){
			i.String()
			println "***"
		} */
		//NodeTree oneElement = new NodeTree(1)
		//NodeTree smallMultiElement = new NodeTree(3)
		//NodeTree largeMultiElement = new NodeTree(5)
		//NodeTree Clone = new NodeTree()
		//Clone.root = largeMultiElement.cloneTree()
		//largeMultiElement.CalcFitness()
		//println largeMultiElement.fitness
		//(oneElement.String())
		//smallMultiElement.String()
		//largeMultiElement.String()
		//Clone.String()
		//println oneElement.calcTreeValue()
		//smallMultiElement.CalcFitness()
		//println smallMultiElement.fitness
		//println largeMultiElement.calcTreeValue()

	}
}
