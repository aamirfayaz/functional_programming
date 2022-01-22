object A
case object B

import java.io._

/**
 --> case objects extend the Serializable trait, so they can be serialized.
     Regular objects cannot by default:
 --> case objects get default implementation of equals, hashCode
 --> pattern matching support
 --> A prettier implementation of toString
 */
//new ObjectOutputStream(new ByteArrayOutputStream).writeObject(A); java.io.NotSerializableException
new ObjectOutputStream(new ByteArrayOutputStream).writeObject(B)