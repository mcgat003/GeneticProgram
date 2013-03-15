package geneticProgramming

class teststuff {
	def static main(args){
		//NodeTree oneElement = new NodeTree(1)
		//NodeTree smallMultiElement = new NodeTree(3)
		NodeTree largeMultiElement = new NodeTree(5)
		NodeTree Clone = new NodeTree()
		Clone.root = largeMultiElement.cloneTree()
		largeMultiElement.Testit()
		

		//largeMultiElement.CalcFitness()
		//println largeMultiElement.fitness
		//(oneElement.String())
		//smallMultiElement.String()
		largeMultiElement.String()
		Clone.String()
		//println oneElement.calcTreeValue()
		//println smallMultiElement.calcTreeValue()
		//println largeMultiElement.calcTreeValue()

	}
}
