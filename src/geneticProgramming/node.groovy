package geneticProgramming

import geneticProgramming.operators.*

class node {

	def public operate
	def parent
	def children
	def value
	def depth
	def index
		
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
	def copyRoot(){
		node(this.(operate))
		
	}
	def copyNode(clonePar){
		node(this.operate,clonePar)
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
	def checkIfVariable(){
		if (this.operate.isVariable){
			NodeTree.xValue
		} else {
		value
		}
	}
	
	def changeOp(op){
		this.operate = op
		calcChildren()
	}
	def String(){operate.String()}
}
