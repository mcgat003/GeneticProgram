package geneticProgramming

import geneticProgramming.operators.*


class NodeTree {
def fitness
def opArray=[Times(),Plus(),Divide(),Minus()]
def varArray=["x", "y", "z"]
//determines percentage of variables generated
def varPercent = 5
Random randOp= new Random()
def root
def NodeTree(s){
	root = create(s)
}
def create(s){
	if (s == 1){
		new node(generateTerminal())
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
			i.changeOp(generateTerminal())
		}
		r
	}
}
	def generateTerminal(){
		if(varPercent == 0){
			new TerminalOp()
		}else{
			int decider = randOp.nextInt(varPercent)		
			if (decider == 1){
				int chooseVar = randOp.nextInt(100)%varArray.size
				new VariableOp(varArray[chooseVar])
			}else{
				new TerminalOp()
			}
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
