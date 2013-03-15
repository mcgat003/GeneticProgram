package geneticProgramming




class NodeTree implements Comparable{
def public static xValue
def maxIndex
def fitness
def opArray=[Times(),Plus(),Divide(),Minus()]
def varArray=["x"]
//determines percentage of variables generated
def varPercent = 5
Random randOp= new Random()
def public root
def NodeTree(){
	}
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
		//note this only calculates for ((x+4)/2+x from x=0 to 10 incrimenting by 1)
		def functionVal
		int treeVal
		fitness =0
		for (i in 0..10){
			xValue = i
			functionVal = (i+4)/2
			treeVal = this.calcTreeValue() 
			fitness = fitness+ Math.abs(treeVal.minus(functionVal))
		}
	}
	def generateTerminal(){
		if(varPercent == 0){
			new TerminalOp()
		}else{
			int decider = randOp.nextInt(varPercent)		
			if (decider == 1){
				new VariableOp()
			}else{
				new TerminalOp()
			}
		}
	}
	def calcIndex(){
		def ind = 0
		maxIndex =0
		root.index = ind
		for (i in root.children){
			ind++
			calcIndexRecursion(i,ind)
		}
		maxIndex
	}
	def calcIndexRecursion(node, ind){
		node.index = ind
		for (i in node.children){
			ind++
			calcSizeRecursion(i,ind)
		}
		if (maxIndex<ind){maxIndex=ind}
	}
	def cloneTree(){
		def newRoot= new node(root.operate.copy())
		newRoot.operate.value = root.operate.value
		for (i in 0..<root.operate.aerity){
			newRoot.children[i] = cloneTreeRecursion(newRoot,this.root.children[i])
		}
		newRoot
	}
	def cloneTreeRecursion(clonePar,oldNode){
		def newNode = new node(oldNode.operate.copy(),clonePar)
		newNode.operate.value = oldNode.operate.value
		for (i in 0..<oldNode.operate.aerity){
			newNode.children[i] = cloneTreeRecursion(newNode,oldNode.children[i])
		}
		newNode
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
		root.checkIfVariable()
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
	
	public int compareTo(pair2) {
	if (this.fitness > pair2.fitness){
			1
		} else if (this.fitness < pair2.fitness) {
			-1
		} else {
			0
		}
	}
	
}
