import React from 'react'

import Lottie from 'react-lottie-player'
// Alternatively:
// import Lottie from 'react-lottie-player/dist/LottiePlayerLight'

import lottieJson from 'assets/lottie/animation.json'

export default function Animations() {
  return (
    <Lottie className='lottie'
      loop
      animationData={lottieJson}
      play
    />
  )
}