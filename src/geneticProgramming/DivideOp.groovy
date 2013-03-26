package geneticProgramming

class DivideOp extends operator {
	def hasChildren=true
	def aerity = 2
	def copy(){
		new DivideOp()
	}
	def calculate(child){
		def childOne = child[0].checkIfVariable()
		def childTwo = child[1].checkIfVariable()
		if (childTwo == 0){
			1
		}else{
			childOne / childTwo
		}
	}
	

	
	def String(){ "/"}
}
