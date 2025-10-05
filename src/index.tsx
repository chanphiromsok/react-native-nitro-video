import { getHostComponent } from 'react-native-nitro-modules';
const NitroVideoConfig = require('../nitrogen/generated/shared/json/NitroVideoConfig.json');
import type {
  NitroVideoMethods,
  NitroVideoProps,
} from './NitroVideo.nitro';

export const NitroVideoView = getHostComponent<
  NitroVideoProps,
  NitroVideoMethods
>('NitroVideo', () => NitroVideoConfig);
