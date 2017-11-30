package medium

/**
 * Created by engry on 2017/11/30.
 * 337. House Robber III
 */
private class TreeNode(var _value: Int) {
  var value: Int = _value
  var left: TreeNode = null
  var right: TreeNode = null
}

object ScalaHouseRobber3 {
  /**
   * my solution
   */
  def robhouse(root: TreeNode, canrob: Boolean): Int ={
    if(root == null)
      return 0

    val robsum = {
      if(canrob)
        robhouse(root.left, false) + robhouse(root.right, false) + root._value
      else
        0
    }
    val norobsum = robhouse(root.left, true) + robhouse(root.right, true)
    return   robsum max norobsum
  }

  /**
   * other solution
   */
  def robmoney(root: TreeNode): (Int, Int) = {
    if(root == null)
      return (0, 0)
    val (leftrob, leftnorob) = robmoney(root.left)
    val (rightrob, rightnorob) = robmoney(root.right)
    (leftnorob  + rightnorob + root.value, leftrob max leftnorob + rightrob max rightnorob)
  }

  def rob(root: TreeNode): Int = {
    val (rootrob, rootnorob) = robmoney(root)
    rootrob max rootnorob
    //return robhouse(root, true)
  }

}
