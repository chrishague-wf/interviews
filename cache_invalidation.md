What is the intent of the author in the following code block?

```actionscript
public function get hasThreadModification():Boolean
{
    var hasThreadMod:Boolean = (this.threadModMap.size() > 0);

	if (hasThreadMod)
	{
		// clean-up threadModMap
		var threads:Array = this.threadModMap.valuesToArray();
		for each (var thread:CommentThread in threads)
		{
			if (!(thread.isNew || thread.isPending))
			{
				var hasCommentMod:Boolean = false;
				for each (var comment:Comment in thread.comments)
				{
					hasCommentMod = comment.isNew || comment.isEditing;
					if (hasCommentMod)
					{
						break;
					}
				}

				if (!hasCommentMod)
				{
					this.threadModMap.remove(thread.keyname);
				}
			}
		}
		// end clean-up
	}

	if (hasThreadMod)
	{
		hasThreadMod = (this.threadModMap.size() > 0);
	}

	return hasThreadMod;
}
```

What could be done to improve this? Is this the right way to go about what the author is trying to do?
