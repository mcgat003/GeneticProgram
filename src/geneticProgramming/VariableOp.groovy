package geneticProgramming

import java.util.Random;

class VariableOp extends operator {
	def hasChildren=false
	def varArray=["x"]
	Random randOp= new Random()
	def VariableOp(name){
		int chooseVar = randOp.nextInt(100)%varArray.size
		value = varArray[chooseVar]
	}
	def aerity = 0
	def copy(){
		new VariableOp()
	}
	def value
	def calculate(child){
		node
	}
	def isVariable=true


	
	def String(){
		value
	}
	def setValue(i){
		i
	}

}
