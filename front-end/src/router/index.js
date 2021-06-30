import { createRouter, createWebHistory } from "vue-router";
import Home from '@/pages/home.vue';
import MemberRegister from '@/pages/members/memberRegister.vue';
import MemberList from '@/pages/members/memberList.vue';
import BookRegister from '@/pages/books/bookRegister.vue';
import BookList from '@/pages/books/bookList.vue';
import RentalRegister from '@/pages/rentals/rentalRegister.vue';
import RentalList from '@/pages/rentals/rentalList.vue';

const router = createRouter({
    history: createWebHistory(),
    routes: [
        {
            path: '/',
            name: 'Home',
            component: Home
        },
        {
            path: '/member/create',
            name: 'MemberRegister',
            component: MemberRegister
        },
        {
            path: '/member/list',
            name: 'MemberList',
            component: MemberList
        },
        {
            path: '/book/create',
            name: 'BookRegister',
            component: BookRegister
        },
        {
            path: '/book/list',
            name: 'BookList',
            component: BookList
        },
        {
            path: '/rental/create',
            name: 'RentalRegister',
            component: RentalRegister
        },
        {
            path: '/rental/list',
            name: 'RentalList',
            component: RentalList
        }
    ]
});

export default router;