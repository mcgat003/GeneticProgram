package geneticProgramming

import geneticProgramming.operators.*

class node {

	def operate
	def parent
	def children
	def value
	def depth
		
	def node(op, par){
		operate = op 
		parent = par
		depth = parent.depth + 1
		children= []
		calcChildren()
		
	}
	def node(op){
		operate= op
		parent = null
		depth=0
		children= []
		calcChildren()
	}
	def void calcNodeValue(){
		value = this.operate.calculate(this.children)
	}
	def calcChildren(){
		for(i in 0..<operate.aerity){
			def temp = new node(new PlaceHolder(),this)
			children += temp
			
		}
	}
	def changeOp(op){
		this.operate = op
		calcChildren()
	}
	def String(){operate.String()}
}