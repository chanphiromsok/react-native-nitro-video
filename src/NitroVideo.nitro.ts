import type {
  HybridView,
  HybridViewMethods,
  HybridViewProps,
} from 'react-native-nitro-modules';

export interface NitroVideoProps extends HybridViewProps {
  color: string;
}
export interface NitroVideoMethods extends HybridViewMethods {}

export type NitroVideo = HybridView<
  NitroVideoProps,
  NitroVideoMethods
>;
