This user facing code is triggered many thousands of times a day.
Walk through the following code block line-by-line. Explain what each line does.

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

This is code from a system that handles threaded discussions with comments.
What does this code calculate in relation to the comment thread system?
What could be done to improve how this is calculated?
