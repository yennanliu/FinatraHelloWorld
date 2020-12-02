import org.scalatest.flatspec.AnyFlatSpec
import utils.MsgChecker

class MsgCheckerTest extends AnyFlatSpec{

  val msg_checker = new MsgChecker

  "List1 length" should "equal as expect" in {
    val myList_1 = List(1,2,3)
    assert (msg_checker.CheckListLength (myList_1) === "equals or larger than 3")
  }

  "List2 length" should "equal as expect" in {
    val myList_2 = List(1,2)
    assert (msg_checker.CheckListLength (myList_2) === "equals 2")
  }

  "List3 length" should "equal as expect" in {
    val myList_3 = List(1)
    assert (msg_checker.CheckListLength (myList_3) ===  "equals 1")
  }
}
