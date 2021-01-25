# 思路

题目中的**无限制重复被选取，吓得我赶紧想想 出现0 可咋办**，然后看到下面提示：1 <= candidates[i] <= 200，我就放心了。

本题和[回溯算法：求组合问题！](https://mp.weixin.qq.com/s/OnBjbLzuipWz_u4QfmgcqQ)，[回溯算法：求组合总和！](https://mp.weixin.qq.com/s/HX7WW6ixbFZJASkRnCTC3w)和区别是：本题没有数量要求，可以无限重复，但是有总和的限制，所以间接的也是有个数的限制。

本题搜索的过程抽象成树形结构如下：

![39.组合总和](https://pic.leetcode-cn.com/1608714655-vKitJt-file_1608714654907)
注意图中叶子节点的返回条件，因为本题没有组合数量要求，仅仅是总和的限制，所以递归没有层数的限制，只要选取的元素总和超过target，就返回！

而在[回溯算法：求组合问题！](https://mp.weixin.qq.com/s/OnBjbLzuipWz_u4QfmgcqQ)和[回溯算法：求组合总和！](https://mp.weixin.qq.com/s/HX7WW6ixbFZJASkRnCTC3w) 中都可以知道要递归K层，因为要取k个元素的组合。

## 回溯三部曲

* 递归函数参数 

这里依然是定义两个全局变量，二维数组result存放结果集，数组path存放符合条件的结果。（这两个变量可以作为函数参数传入）

首先是题目中给出的参数，集合candidates, 和目标值target。

此外我还定义了int型的sum变量来统计单一结果path里的总和，其实这个sum也可以不用，用target做相应的减法就可以了，最后如何target==0就说明找到符合的结果了，但为了代码逻辑清晰，我依然用了sum。

**本题还需要startIndex来控制for循环的起始位置，对于组合问题，什么时候需要startIndex呢？**

我举过例子，如果是一个集合来求组合的话，就需要startIndex，例如：[回溯算法：求组合问题！](https://mp.weixin.qq.com/s/OnBjbLzuipWz_u4QfmgcqQ)，[回溯算法：求组合总和！](https://mp.weixin.qq.com/s/HX7WW6ixbFZJASkRnCTC3w)。

如果是多个集合取组合，各个集合之间相互不影响，那么就不用startIndex，例如：[回溯算法：电话号码的字母组合](https://mp.weixin.qq.com/s/e2ua2cmkE_vpYjM3j6HY0A)

**注意以上我只是说求组合的情况，如果是排列问题，又是另一套分析的套路，后面我再讲解排列的时候就重点介绍**。

代码如下：

```
vector<vector<int>> result;
vector<int> path;
void backtracking(vector<int>& candidates, int target, int sum, int startIndex) 
```
**PS：相信很多小伙伴刷题的时候面对力扣上近两千到题目，感觉无从下手，我花费半年时间整理了[leetcode刷题指南](https://github.com/youngyangyang04/leetcode-master)，不仅有详细经典题目刷题顺序而且对应题解来排好了，难点还有视频讲解，按照list一道一道刷就可以了，绝对是最强攻略！**

* 递归终止条件

在如下树形结构中：

![39.组合总和](https://pic.leetcode-cn.com/1608714655-vKitJt-file_1608714654907)

从叶子节点可以清晰看到，终止只有两种情况，sum大于target和sum等于target。

sum等于target的时候，需要收集结果，代码如下：

```
if (sum > target) {
    return;
}
if (sum == target) {
    result.push_back(path);
    return;
}
```

* 单层搜索的逻辑 

单层for循环依然是从startIndex开始，搜索candidates集合。

**注意本题和[回溯算法：求组合问题！](https://mp.weixin.qq.com/s/OnBjbLzuipWz_u4QfmgcqQ)、[回溯算法：求组合总和！](https://mp.weixin.qq.com/s/HX7WW6ixbFZJASkRnCTC3w)的一个区别是：本题元素为可重复选取的**。

如何重复选取呢，看代码，注释部分：

```
for (int i = startIndex; i < candidates.size(); i++) {
    sum += candidates[i];
    path.push_back(candidates[i]);
    backtracking(candidates, target, sum, i); // 关键点:不用i+1了，表示可以重复读取当前的数
    sum -= candidates[i];   // 回溯
    path.pop_back();        // 回溯
}
```

按照[关于回溯算法，你该了解这些！](https://mp.weixin.qq.com/s/gjSgJbNbd1eAA5WkA-HeWw)中给出的模板，不难写出如下C++完整代码：

```
// 版本一
class Solution {
private:
    vector<vector<int>> result;
    vector<int> path;
    void backtracking(vector<int>& candidates, int target, int sum, int startIndex) {
        if (sum > target) {
            return;
        }
        if (sum == target) {
            result.push_back(path);
            return;
        }

        for (int i = startIndex; i < candidates.size(); i++) {
            sum += candidates[i];
            path.push_back(candidates[i]);
            backtracking(candidates, target, sum, i); // 不用i+1了，表示可以重复读取当前的数
            sum -= candidates[i];
            path.pop_back();
        }
    }
public:
    vector<vector<int>> combinationSum(vector<int>& candidates, int target) {
        result.clear();
        path.clear();
        backtracking(candidates, target, 0, 0);
        return result;
    }
};
```

## 剪枝优化 

在这个树形结构中：

![39.组合总和](https://pic.leetcode-cn.com/1608714655-vKitJt-file_1608714654907)

以及上面的版本一的代码大家可以看到，对于sum已经大于target的情况，其实是依然进入了下一层递归，只是下一层递归结束判断的时候，会判断sum > target的话就返回。

其实如果已经知道下一层的sum会大于target，就没有必要进入下一层递归了。

那么可以在for循环的搜索范围上做做文章了。

**对总集合排序之后，如果下一层的sum（就是本层的 sum + candidates[i]）已经大于target，就可以结束本轮for循环的遍历**。

如图：


![39.组合总和1](https://pic.leetcode-cn.com/1608714655-BNwJhW-file_1608714654889)

for循环剪枝代码如下：

```
for (int i = startIndex; i < candidates.size() && sum + candidates[i] <= target; i++) 
```

整体代码如下：（注意注释的部分）

```
class Solution {
private:
    vector<vector<int>> result;
    vector<int> path;
    void backtracking(vector<int>& candidates, int target, int sum, int startIndex) {
        if (sum == target) {
            result.push_back(path);
            return;
        }

        // 如果 sum + candidates[i] > target 就终止遍历
        for (int i = startIndex; i < candidates.size() && sum + candidates[i] <= target; i++) {
            sum += candidates[i];
            path.push_back(candidates[i]);
            backtracking(candidates, target, sum, i);
            sum -= candidates[i];
            path.pop_back();

        }
    }
public:
    vector<vector<int>> combinationSum(vector<int>& candidates, int target) {
        result.clear();
        path.clear();
        sort(candidates.begin(), candidates.end()); // 需要排序
        backtracking(candidates, target, 0, 0);
        return result;
    }
};
```

# 总结 

本题和我们之前讲过的[回溯算法：求组合问题！](https://mp.weixin.qq.com/s/OnBjbLzuipWz_u4QfmgcqQ)、[回溯算法：求组合总和！](https://mp.weixin.qq.com/s/HX7WW6ixbFZJASkRnCTC3w)有两点不同：

* 组合没有数量要求 
* 元素可无限重复选取 

针对这两个问题，我都做了详细的分析。

并且给出了对于组合问题，什么时候用startIndex，什么时候不用，并用[回溯算法：电话号码的字母组合](https://mp.weixin.qq.com/s/e2ua2cmkE_vpYjM3j6HY0A)做了对比。

最后还给出了本题的剪枝优化，这个优化如果是初学者的话并不容易想到。

**在求和问题中，排序之后加剪枝是常见的套路！**

可以看出我写的文章都会大量引用之前的文章，就是要不断作对比，分析其差异，然后给出代码解决的方法，这样才能彻底理解题目的本质与难点。

「代码随想录」目前正在循序渐进讲解算法，目前已经讲到了动态规划，[点击这里](https://img-blog.csdnimg.cn/20210102121706654.png)和上万录友一起打卡学习，来看看，你一定会发现相见恨晚！


**如果感觉对你有帮助，不要吝啬给一个👍吧！**


