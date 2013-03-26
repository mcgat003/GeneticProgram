package geneticProgramming

class GPrunner {	
	static testForest
	static avgBestFitness
	static bestFitness
	static bestFunction
	
	static newGenerations(numGenerations, numTrees, treeSize){
		testForest	= new Forest(numTrees, treeSize)
		for (i in 1..numGenerations){
			testForest.nextGeneration()
			}
		if	(testForest.best.fitness < bestFitness){
			bestFitness = testForest.best.fitness
			bestFunction = testForest.best.root.calcString()
			}
		}
	
	static runExperiment(numRuns, numGenerations, numTrees, treeSize){
		def sumFitness = 0
		bestFitness = 10000
		bestFunction = ""
		for (int i in 1..numRuns){
			newGenerations(numGenerations, numTrees, treeSize)
			sumFitness = sumFitness + testForest.best.fitness				
		}
		avgBestFitness = sumFitness/numRuns
		println "Average best fitness (per run) = " + avgBestFitness
		println "Overall best fitness = " + bestFitness
		println "Overall best funtion:"
		println bestFunction
	}
	
	static main(args) {
			runExperiment(10, 10, 10, 10)	
	}

}



