import { Outlet, useLocation } from 'react-router-dom'
import Footer from '../Footer/Index'
import Header from '../Header'

// component: 레이아웃
export default function Container() {

    // state: 현재 페이지 path name 상태
    const { pathname } = useLocation();

    // render: 레이아웃 렌더링
  return (
    <>
        {pathname !== '/auth' && <Header />}
        <Outlet />
        {pathname !== '/auth' && <Footer/>}
    </>
  )
}
