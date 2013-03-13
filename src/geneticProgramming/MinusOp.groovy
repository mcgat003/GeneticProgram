package geneticProgramming

class MinusOp extends operator {
	def aerity = 2
	def calculate(child){
		child[0].value - child[1].value
	}
	def String() {
		"-"
	}

}