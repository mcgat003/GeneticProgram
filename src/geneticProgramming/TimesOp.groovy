package geneticProgramming

class TimesOp extends operator {
def aerity = 2
def copy(){
	new TimesOp()
}
	def calculate(child){
		def childOne = child[0].operate.checkIfVariable()
		def childTwo = child[1].operate.checkIfVariable()
		childOne * childTwo
	}
	def String() {
		"*"
	}

}
