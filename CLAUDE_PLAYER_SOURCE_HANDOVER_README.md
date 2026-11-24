# Claude source handover — CloudStream player v4.9.1

This branch contains the actual source text fetched from upstream CloudStream tag v4.9.1 (commit c92e0cf02eda0429fbb4b2fcea4b528cb65aa9fb), not just a list of file names.

Source dump files:
- CLAUDE_PLAYER_CORE_SOURCE_1_v4.9.1.txt — PlayerView, PlayerGestureHelper, CS3IPlayer, IPlayer, FullScreenPlayer
- CLAUDE_PLAYER_CORE_SOURCE_2_v4.9.1.txt — AbstractPlayerFragment, GeneratorPlayer, subtitle decoder, subtitle helper, downloaded player activity
- CLAUDE_PLAYER_SUPPORT_SOURCE_3_v4.9.1.txt — offline playback, preview generator, PiP, subtitle parser, renderer factory
- CLAUDE_PLAYER_SUPPORT_SOURCE_4_v4.9.1.txt — player generator/interface/support files
- CLAUDE_PLAYER_RESOURCES_SOURCE_5_v4.9.1.txt — player XML layouts and strings
- CLAUDE_PLAYER_DEPENDENCIES_SOURCE_6_v4.9.1.txt — colors/dimensions/styles, app Gradle dependencies and version catalog
- CLAUDE_PLAYER_REMAINING_SOURCE_7_v4.9.1.txt — remaining player helper and live-preview files

Each file has exact upstream repository paths as section headings and full fetched source text.

Task for Claude: create a separate, simple local-video player app. Reuse the actual CloudStream player code; do not create a generic Media3 clone and do not rename/strip CloudStream. Integrate local videos via Android Storage Access Framework/content URIs. Keep the custom player resize/zoom, gesture, subtitle rendering and sync controls where technically applicable. Remove streaming/provider/catalog functionality. Trace dependencies, identify required resource/library changes, deliver complete buildable source and a reproducible Android build. Respect GPL-3.0.
