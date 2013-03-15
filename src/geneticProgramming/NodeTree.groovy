package geneticProgramming

import geneticProgramming.operators.*


class NodeTree {
def public static xValue
def fitness
def opArray=[Times(),Plus(),Divide(),Minus()]
def varArray=["x"]
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
	def void CalcFitness(){
		//note this only calculates for ((x+4)/2+x from x=0 tp 10 incrimenting by 1)
		def functionVal
		def treeVal
		fitness =0
		for (i in 0..3){
			xValue = i
			functionVal = (i+4)/2
			treeVal = this.calcTreeValue() 
			fitness = fitness+ Math.abs(treeVal-functionVal)
			println Math.abs(treeVal-functionVal)
			println fitness
		}
	}
		
	def replace
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
	def calcTreeValue(){
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
