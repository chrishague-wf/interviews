What could go wrong with the following code block? Any improvements to how data is stored/retrieved?

```actionscript
private var _threadList:ArrayCollection;

public function get threadList():ArrayCollection
{
	if (!_threadList)
	{
		var threads:Array = this.threadMap.valuesToArray();
		_threadList = new ArrayCollection(threads);

		if(sec is IPresentationSection)
		{
			_threadList.sort = SortUtil.createSort(CommentThread.sortField, false, false, PresentationCommentThread.compareThreads);
		}
		else
		{
			_threadList.sort = SortUtil.createSort(CommentThread.sortField, false, false, CommentThread.compareThreads);
		}

		_threadList.refresh();
	}

	return _threadList;
}
```

__NOTE__:
[`ArrayCollection`](http://help.adobe.com/en_US/FlashPlatform/reference/actionscript/3/mx/collections/ArrayCollection.html)
will automatically update when the backing source `Array` is modified. The `source` can be set
with the `ArrayCollection.source` property or as the only constructor argument.

