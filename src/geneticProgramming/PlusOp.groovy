package geneticProgramming

class PlusOp extends operator {
	def aerity = 2
	def calculate(child){
		child[0].value + child[1].value
	}
	def String(){
	    "+"
	}
}