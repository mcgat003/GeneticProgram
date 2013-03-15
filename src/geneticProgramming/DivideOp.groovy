package geneticProgramming

class DivideOp extends operator {
	def aerity = 2
	def calculate(child){
		def childOne = child[0].operate.checkIfVariable()
		def childTwo = child[1].operate.checkIfVariable()
		if (childTwo == 0){
			1
		}else{
			childOne / childTwo
		}
	}
	def String(){ "/"}
}
