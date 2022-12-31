# DiffUtil
 ### Intro ###
DiffUtil is a utility class by Google that calculates the difference between two lists and outputs a list of update operations that converts the first list into the second one.
 ### Problem ###
 Say, we use room database. Now we add one item to room 
 which has previous n items. So after adding it should reflect in 
 recycler view. Now, what recycler view does is that it renders all items.

 This is a performance issue.

 ### Solution ###
 There are 2 ways 2 implement Diff Utils:

#### 1. Recycler View Adpater ####
- We have to implement Diff Util.
####  2. List Adapter ####
- By default Diff Util is implemented.
- Automatically use Diff Util, execute difference in background.

Both are implemented in the code. For 1 check ProgrammingListAdapter and for 2 check ProgrammingRecyclerViewAdapter.

Happy coding 👨‍💻

## Demo
<p align="center">
<img width="300" src="https://i.ibb.co/gPx54zf/diffutil.gif">
</p>
