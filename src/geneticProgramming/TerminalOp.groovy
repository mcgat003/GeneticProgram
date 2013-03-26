package geneticProgramming

class TerminalOp extends operator {
	
	def terminalOp(){
		
	}
	def hasChildren=false
	def aerity = 0
	def copy(){
		new TerminalOp()
	}
	def value = generateValue()
	def calculate(child){
		value
	}
	def generateValue(integer){
		Random randValue = new Random()
		randValue.nextInt(10)
	}
	

	
	def String(){
		value
	}

}

