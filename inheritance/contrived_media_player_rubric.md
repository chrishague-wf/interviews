###Level 1
- Create new `Playlist` class with `public` next/previous functionality calling into
stubbed `MediaPlayer` play/stop methods
- Dual Audio/Video support (in play/pause/stop) with simple if/else
- Call existing play/pause functionality for play/pause toggle; no code duplication
- Create new `IMediaPlayer` with dual implementations:`MediaPlayerImpl` and `MediaPlayerMobileImpl`

###Level 2
- Dual Audio/Video support (in play/pause/stop) with abstracted `private` or `protected` functions
- Create `AbstractMediaPlayer` with two children, `MediaPlayer` and `MediaPlayerMobile`, with
different constructors. Use `IPlayerSubSystem` for `systemControl` and initialize appropriately in
new subclassed constructors.
