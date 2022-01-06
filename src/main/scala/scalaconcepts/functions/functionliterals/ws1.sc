def convert: String => String = (value: String) => "converted"
def verify = (value: String) => if(value == "converted") "valid" else "invalid"

val r = (convert compose verify)("")

//def to f literal
