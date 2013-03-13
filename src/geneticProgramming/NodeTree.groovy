package geneticProgramming

import geneticProgramming.operators.*


class NodeTree {
def fitness
def opArray=[Times(),Plus(),Divide(),Minus()]
Random randOp= new Random()
def root
def NodeTree(s){
	root = create(s)
}
def create(s){
	if (s == 1){
		new node(new TerminalOp())
	}
	else{
		def Q=[]
		def r= new node(getRandOp())
		def c = 1
		for(i in 0..<r.children.size){
			Q.push(r.children[i])
		}
		while((c + Q.size)<s){
			def index = randOp.nextInt(Q.size)
			def child = Q[index]
			Q.remove(index)
			child.changeOp(getRandOp())
			c=c+1
			for (i in 0..<child.children.size){
				Q.push(child.children[i])
			}
		}
		for(i in Q){
			i.changeOp(new TerminalOp())
		}
		r
	}
}
	def getRandOp(){
		opArray[randOp.nextInt(4)]
	}
	def String() {
		createString(root)
	}
	def createString(node){
		for (i in node.children){
			createString(i)
		}
		println node.String()
	}
	def calcTreeValue(ww){
		setValue(root)
		root.value
	}
	def setValue(node){
		for (i in node.children){
			setValue(i)
		}
		node.calcNodeValue()
	}
	def Times(){
		new TimesOp()
	}
	def Plus(){
		new PlusOp()
	}
	def Minus(){
		new MinusOp()
	}
	def Divide(){
		new DivideOp()
	}
}
