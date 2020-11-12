import org.scalatest.flatspec.AnyFlatSpec

// UDF
import schema.adhocSchema

class SchemaTest extends AnyFlatSpec{

  "Book isbn" should "equal as expect" in {
    val book = adhocSchema.Book("123")
    assert (book.isbn === "123")
  }

  "Message sender, recipient, body" should "equal as expect" in {
    val msg = adhocSchema.Message("tom", "jim", "hello there")
    assert (msg.sender === "tom")
    assert (msg.recipient === "jim")
    assert (msg.body === "hello there")
  }
}
