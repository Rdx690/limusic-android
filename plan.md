# VFX MUSIC VAULT X compact premium upgrade

## Implementation approach

Upgrade the existing Kotlin Multiplatform/Compose app in place. Preserve the current YouTube/lyrics/data APIs, DataStore preferences, authentication, media service, queue, download, updater, and player navigation. Limit this pass to presentation geometry, shared card sizing, compact mobile chrome, responsive shelf heights, and accent tokens.

## Design

**Chosen movement:** Spotify-inspired AMOLED music surface with a restrained iOS glass finish.

**Core principles:** compact information density; persistent playback context; horizontal discovery shelves; touch-safe controls with no overflow.

**Color philosophy:** near-black surfaces keep artwork dominant; electric violet marks selection and playback; orange is used sparingly for secondary emphasis and progress-adjacent moments.

**Layout paradigm:** one vertical feed of short, horizontally scrollable shelves, with the greeting/header floating over the first shelf and the player/navigation chrome fixed at the bottom.

**Signature elements:** 60dp greeting bar, 188dp square artwork cards, hairline progress accent, and rounded translucent player/navigation surfaces.

**Interaction and animation:** preserve existing swipe, queue, playback, pagination, and navigation behavior; keep the existing fade/slide/crossfade transitions and reduce only layout footprint.

**Responsive behavior:** shared Dp tokens are used for phone, tablet, and desktop; desktop rail/floating player behavior stays intact while phone bottom chrome remains fixed.

## Project structure

- `composeApp/src/commonMain/.../ui/screen/home`: home feed, shelves, greeting, and responsive dimensions.
- `composeApp/src/commonMain/.../ui/component`: shared cards, mini-player, navigation bar, and playback surfaces.
- `composeApp/src/commonMain/.../ui/theme`: semantic VFX palette and surface tokens.
- `core/data`, `core/domain`, and service modules: unchanged data, authentication, APIs, playback, queue, lyrics, and persistence.
