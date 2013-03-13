package geneticProgramming

class DivideOp extends operator {
	def aerity = 2
	def calculate(child){
		if (child[1].value == 0){
			1
		}else{
			child[0].value / child[1].value
		}
	}
	def String(){ "/"}
}
