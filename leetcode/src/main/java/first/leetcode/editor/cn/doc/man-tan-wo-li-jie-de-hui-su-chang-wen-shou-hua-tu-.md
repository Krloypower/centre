#### 思路
以 [2,5,2,1,2], target = 5 为例。

每次都在做选择，选一个数，然后选下一个，看看当前选择受到哪些限制，去做剪枝（如图）：
- 选过的不能再选
- 不能产生相同的组合

当和为 target，找到一个正确的解，加入解集。当和 >= target，爆掉了，不用继续选了，结束当前递归，继续搜别的分支，找齐所有的解。

因此，回到上一个节点，撤销当前选择的数字，去进入下一个分支。

![image.png](https://pic.leetcode-cn.com/1599737152-dKAqlo-image.png)
#### 对比第 39 题
39题：元素可以重复使用，组合不能重复。
本题：元素不可以重复使用，组合不能重复。

这是 39 题的代码：
```js
const combinationSum = (candidates, target) => {
  const res = [];
  const dfs = (start, temp, sum) => {
    if (sum >= target) {        // 爆掉了，不用继续选数了
      if (sum == target) {      // 加入解集
        res.push(temp.slice()); // temp的拷贝
      }
      return;                   // 结束当前递归
    }
    for (let i = start; i < candidates.length; i++) { // 枚举出选择，从start开始
      temp.push(candidates[i]);          // 加入“部分解”
      dfs(i, temp, sum + candidates[i]); // 往下继续选择，同时sum累加上当前数字
      temp.pop();                        // 撤销选择
    }
  };
  dfs(0, [], 0);
  return res;
};
```
**只需改动三点：**
1. 给定的数组可能有重复的元素，先排序，使得重复的数字相邻，方便去重。

2. for 枚举出选项时，加入下面判断，从而忽略掉同一层重复的选项，避免产生重复的组合。比如[1,2,2,2,5]中，选了第一个 2，变成 [1,2]，它的下一选项也是 2，跳过它，因为如果选它，就还是 [1,2]。

    ```js
    if (i - 1 >= start && candidates[i - 1] == candidates[i]) {
        continue;
    }
    ```
3. 当前选择的数字不能和下一个选择的数字重复，给子递归传`i+1`，避免与当前选的`i`重复。
  
    ```js
    dfs(i + 1, temp, sum + candidates[i]);
    ```


#### 代码

```javascript []
const combinationSum2 = (candidates, target) => {
  candidates.sort((a,b) => a - b ); // 升序排序
  const res = [];

  const dfs = (start, temp, sum) => { // start是索引 当前选择范围的第一个
    if (sum >= target) {        // 爆掉了，不用继续选了
      if (sum == target) {      // 满足条件，加入解集
        res.push(temp.slice()); // temp是引用，所指向的内存后续还要操作，所以拷贝一份
      }
      return;                   // 结束当前递归
    }
    for (let i = start; i < candidates.length; i++) {             // 枚举出当前的选择
      if (i - 1 >= start && candidates[i - 1] == candidates[i]) { // 当前选项和左邻选项一样，跳过
        continue;
      }
      temp.push(candidates[i]);              // 作出选择
      dfs(i + 1, temp, sum + candidates[i]); // 基于该选择，继续选择，递归
      temp.pop();               // 上面的递归结束，撤销选择，回到选择前的状态，切入另一分支
    }
  };

  dfs(0, [], 0);
  return res;
};
```
```go []
func combinationSum2(candidates []int, target int) [][]int {
	sort.Ints(candidates)
	res := [][]int{}

	var dfs func(start int, temp []int, sum int)
	dfs = func(start int, temp []int, sum int) {
		if sum >= target {
			if sum == target {
				t := make([]int, len(temp))
				copy(t, temp)
				res = append(res, t)
			}
			return
		}
		for i := start; i < len(candidates); i++ {
			if i-1 >= start && candidates[i-1] == candidates[i] {
				continue
			}
			temp = append(temp, candidates[i])
			dfs(i+1, temp, sum+candidates[i])
			temp = temp[:len(temp)-1]
		}
	}
	dfs(0, []int{}, 0)
	return res
}

```

#### 再谈我理解的回溯
#### 回溯的要素

我们关心当下有什么选择，作了一个选择之后，会怎么限制下一个选择。

解空间树的节点是动态的，当前的选择决定了下一个选择是怎么展开的。

所以，不仅要关注选择（选项），还要关注约束条件。

前者展开出一棵解的空间树，后者用来为枝，剪去不能产生正确解的分支，避免无效搜索。

第三个要素：目标（结束条件），明确了目标，就知道何时去将解加入解集。

并且让你知道：搜索到某一步时，发现当前的部分解不能通向正确的完整解，搜下去没有意义。

此时回退一步，撤销当前的选择，回到上一个选择的状态，做别的选择。

此路不通，退回去，尝试别的路，**回溯**就是 **choose, explore, unchoose** 的过程。

#### 套路做法（可硬记）
1. 用 for 循环去枚举出所有的选择
2. 做出一个选择
3. 基于这个选择，继续往下选择（递归）
4. 上面的递归结束了，撤销这个选择，进入 for 循环的下一次迭代


#### 回溯 与 嵌套循环
回溯是一种算法，递归不是算法，是一种计算机解决问题的方式。

回溯是借助递归实现的。如果回溯不借助递归，它只能借助循环。

用 for 循环枚举出当前的选项，选了一个，选下一个要嵌套一层循环，枚举出可选的选项。

如果要选很多个，就导致多重的循环嵌套，很费力，代码也很丑。

借助递归解决，递归和子递归就是层级嵌套的关系。

树具有高度的结构重复性，每个节点，都是当前子树的根节点，调用递归负责当前子树的搜索。

#### 虚拟的解空间树

回溯算法并没有显式地创建数据结构，也不是基于已有的数据结构做搜索。

它是隐式地，通过递归，构建出一棵解的空间树。这个空间树中包含了所有的解。

然后通过 dfs 的搜索方式，把解给全部找出来。

如果说它难，应该难在确定出容易搜索（经过充分的剪枝）的解空间结构，剩下的 dfs 和回溯就比较简单了。

#### 好像谈不动了，见解浅薄，只能分享出那么多了，欢迎评论交流。

这是我 39 题的题解：[「手画图解」组合总和 combination sum](https://leetcode-cn.com/problems/combination-sum/solution/shou-hua-tu-jie-zu-he-zong-he-combination-sum-by-x/)


 