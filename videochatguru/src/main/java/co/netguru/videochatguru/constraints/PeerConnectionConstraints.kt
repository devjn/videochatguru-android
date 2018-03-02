package co.netguru.videochatguru.constraints

import org.webrtc.PeerConnection

/**
 * These constraints should be used during PeerConnection construction.
 *
 * @see <a href="https://chromium.googlesource.com/external/webrtc/+/e33c5d918a213202321bde751226c4949644fe5e/webrtc/api/mediaconstraintsinterface.cc">
 *     Available constraints in media constraints interface implementation</a>
 */
class PeerConnectionConstraints(val enableDtlsSrtp: Boolean = true,
                                val enableRtpDataChannel: Boolean = false,
                                /**
                                 * Differentiated Services Code Point - DiffServ is a coarse-grained, class-based mechanism for traffic management.
                                 * @see <a href="https://en.wikipedia.org/wiki/Differentiated_services">DSCP</a>
                                 */
                                val enableDscp: Boolean = false,
                                val disableIpv6: Boolean = false,
                                /**
                                 *  Video stops as soon as you don't have enough bandwidth for the video.
                                 */
                                val suspendBelowMinBitrate: Boolean = false,
                                val combinedAudioVideoBwe: Boolean? = null,

                                val enableCpuOveruseDetection: Boolean = true) {

    fun apply(rtcConfig: PeerConnection.RTCConfiguration): PeerConnection.RTCConfiguration {
        rtcConfig.enableDtlsSrtp = enableDtlsSrtp
        rtcConfig.enableRtpDataChannel = enableRtpDataChannel
        rtcConfig.enableDscp = enableDscp
        rtcConfig.disableIpv6 = disableIpv6
        rtcConfig.suspendBelowMinBitrate = suspendBelowMinBitrate
        rtcConfig.combinedAudioVideoBwe = combinedAudioVideoBwe
        rtcConfig.enableCpuOveruseDetection = enableCpuOveruseDetection
        return rtcConfig
    }

    inner class Builder private constructor() {
        private var enableDtlsSrtp: Boolean = true
        private var enableRtpDataChannel: Boolean = false
        private var enableDscp: Boolean = false
        private var disableIpv6: Boolean = false
        private var suspendBelowMinBitrate: Boolean = false
        private var combinedAudioVideoBwe: Boolean? = null
        private var enableCpuOveruseDetection: Boolean = true;

        fun enableDtlsSrtp(value: Boolean): PeerConnectionConstraints.Builder {
            this.enableDtlsSrtp = value
            return this
        }

        fun enableRtpDataChannel(value: Boolean): PeerConnectionConstraints.Builder {
            this.enableRtpDataChannel = value
            return this
        }

        fun enableDscp(value: Boolean): PeerConnectionConstraints.Builder {
            this.enableDscp = value
            return this
        }

        fun disableIpv6(value: Boolean): PeerConnectionConstraints.Builder {
            this.disableIpv6 = value
            return this
        }

        fun suspendBelowMinBitrate(value: Boolean): PeerConnectionConstraints.Builder {
            this.suspendBelowMinBitrate = value
            return this
        }

        fun combinedAudioVideoBwe(value: Boolean): PeerConnectionConstraints.Builder {
            this.combinedAudioVideoBwe = value
            return this
        }

        fun enableCpuOveruseDetection(value: Boolean): PeerConnectionConstraints.Builder {
            this.enableCpuOveruseDetection = value
            return this
        }


        fun createPeerConnectionConstraints(): PeerConnectionConstraints {
            return PeerConnectionConstraints(this.enableDtlsSrtp, enableRtpDataChannel, enableDscp, disableIpv6, suspendBelowMinBitrate, combinedAudioVideoBwe, enableCpuOveruseDetection)
        }
    }


//    GOOG_PAYLOAD_PADDING("googPayloadPadding")
}