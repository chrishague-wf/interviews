The following is an example of a deep-copy method on an
[_ActionScript_ `HashMap` implementation](https://github.com/jaybaird/as3ds/blob/master/de/polygonal/ds/HashMap.as).

```actionscript
public function toArray():Array
{
        var a:Array = new Array(_size), i:int;
        for each (var p:PairNode in _keyMap)
                a[i++] = p.obj;
        return a;
}
```

Given that `valuesToArray()` is a wrapper for the aforementioned `toArray()`,
what might be some unforseen consequences with the following code?

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

...

public function countThreads():void
{
	var threads:int = 0;
	for each (var ct:CommentThread in _threadList)
	{
		this.trackThreadEdited(ct);
		threads++;
	}
	numTotalThreads = threads;
}
```

__NOTE__:
[`ArrayCollection`](http://help.adobe.com/en_US/FlashPlatform/reference/actionscript/3/mx/collections/ArrayCollection.html)
will automatically update when the backing source `Array` is modified. The `source` can be set
with the `ArrayCollection.source` property or as the only constructor argument.

