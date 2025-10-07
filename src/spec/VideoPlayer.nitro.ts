import type { HybridObject } from 'react-native-nitro-modules';

export interface VideoPlayerSourceBase {
  /**
   * The URI of the asset.
   */
  readonly uri: string;
}

export interface VideoPlayer
  extends HybridObject<{
      android: 'kotlin';
      ios: 'swift';
    }>,
    VideoPlayerSourceBase {
  replaceVideoSource(source: VideoPlayerSourceBase): void;
  play(): void;
  pause(): void;
  stop(): void;
  release(): void;
}
