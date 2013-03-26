package geneticProgramming

class PlusOp extends operator {
	def hasChildren=true
	def aerity = 2
	def copy(){
		new PlusOp()
	}
	def calculate(child){
		def childOne = child[0].checkIfVariable()
		def childTwo = child[1].checkIfVariable()
		childOne + childTwo
	}
	
	
	def String(){
	    "+"
	}
}