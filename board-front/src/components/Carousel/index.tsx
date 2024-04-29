import Slider from 'react-slick';
import 'slick-carousel/slick/slick.css'
import 'slick-carousel/slick/slick-theme.css'
import'./style.css';
import { AUTH_PATH, BOARD_PATH, BOARD_WRITE_PATH } from 'constant';
import { useNavigate } from 'react-router-dom';
import { useLoginUserStore } from 'stores';
import Animations from 'components/Animation';

const Carousel = () => {

   // function: 네이게이트 함수
   const navigate = useNavigate();

   // state: 로그인 유저 상태
   const { loginUser } = useLoginUserStore();

    // event handler: 사이드 카드 클릭 이벤트 처리
    const onSideCardClickHandler = () => {
        console.log(loginUser);
        if(loginUser == null){
            alert("작성을 하려면 로그인이 필요합니다.");
            navigate(AUTH_PATH());
        }
        else navigate(BOARD_PATH() + '/' + BOARD_WRITE_PATH());
    }

    // 옵션
    const settings = {
        dots: true,
        infinite: true,
        autoplay: false,      // 자동 재생
        autoplaySpeed: 3000, // 자동 재생 속도
        slidesToShow: 1
    }

    return (
        <div className='carousel'>
            <Slider { ...settings }>
            <div className='carousel-item'>
                <Animations/>
                <div className='carousel-item-left'>
                    </div>
                <div className='carousel-item-right'>
                    <div className='carousel-item-title'>
                    {'상상했던 모든 것을\n지니에서 실현해 보세요!'}
                    </div>
                    <div className='carousel-item-description'>
                    {'특별한 아이디어를 가지고 있으신가요?\n지금 바로 지니에 작성해보세요.'}
                    </div>
                    <div className='carousel-item-button' onClick={onSideCardClickHandler}>
                        {'지금 글쓰기'}
                    </div>
               </div>
            </div>
            </Slider>
        </div>
    );
}

export default Carousel;